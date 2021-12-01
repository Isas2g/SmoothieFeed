from pprint import pprint

from rest_framework import permissions, status
from rest_framework.response import Response
from rest_framework.views import APIView
import vk_api
from rest_framework_simplejwt.authentication import JWTTokenUserAuthentication

from user.models import UserUseSocialMedia


class AuthVK(APIView, JWTTokenUserAuthentication):
    permission_classes = [permissions.IsAuthenticated]

    def get(self, request):
        user_id = self.authenticate(request)[0].pk
        token = UserUseSocialMedia.objects.get(user_id=user_id).token
        vk_session = vk_api.VkApi(token=token)
        vk = vk_session.get_api()
        news = vk.newsfeed.get(filters='post', count=1)
        return Response(news, status=status.HTTP_200_OK)