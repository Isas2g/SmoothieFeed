from pprint import pprint

from rest_framework import permissions, status
from rest_framework.response import Response
from rest_framework.views import APIView
import vk_api
from rest_framework_simplejwt.authentication import JWTTokenUserAuthentication

from user.models import UserUseSocialMedia

from social_media.models import SocialMedia

VK = SocialMedia.objects.get(name='Вконтакте')


def get_sort_news(news):
    banned_types = [
        'video',
        'audio',
        'doc',
        'graffiti',
        'link',
        'note',
        'app',
        'poll',
        'page',
        'album',
        'market',
        'market_album',
        'sticker',
        'pretty_cards',
        'event',
    ]
    qroups = news['groups']
    news = news['items']
    sort_news = []
    for one_news in news:
        group_id = one_news['source_id'] * -1
        if group_id < 0:
            continue
        qroup = list(filter(lambda x: x['id'] == group_id, qroups))[0]
        attachments = list(filter(lambda x: x['type'] not in banned_types, one_news['attachments']))
        sort_news.append(
            {
                'attachments': attachments,
                'text': one_news['text'],
                'date': one_news['date'],
                'author': {
                    'icon': qroup['photo_50'],
                    'name': qroup['name'],
                },
            }
        )
    return sort_news


class NewsVKView(APIView, JWTTokenUserAuthentication):
    permission_classes = [permissions.IsAuthenticated]

    def get(self, request):
        user_id = self.authenticate(request)[0].pk
        token = UserUseSocialMedia.objects.get(user_id=user_id, media=VK).token
        vk_session = vk_api.VkApi(token=token)
        vk = vk_session.get_api()
        news = get_sort_news(vk.newsfeed.getRecommended(count=20))
        return Response(news, status=status.HTTP_200_OK)
