
from rest_framework import permissions, status
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework_simplejwt.authentication import JWTTokenUserAuthentication

from social_media.models import SocialMedia
from user.models import UserUseSocialMedia

Instagram = SocialMedia.objects.get(name='Instagram')


class NewsInstagramView(APIView, JWTTokenUserAuthentication):
    permission_classes = [permissions.IsAuthenticated]

    def get(self, request):
        user_id = self.authenticate(request)[0].pk
        token = UserUseSocialMedia.objects.get(user_id=user_id, media=Instagram).token
        news = []
        return Response(news, status=status.HTTP_200_OK)