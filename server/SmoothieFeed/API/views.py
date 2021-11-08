from rest_framework import mixins, viewsets, status
from rest_framework.generics import (CreateAPIView,
                                     ListAPIView,
                                     RetrieveUpdateDestroyAPIView,
                                     UpdateAPIView,
                                     RetrieveAPIView,
                                     RetrieveUpdateAPIView, ListCreateAPIView, get_object_or_404,
                                     )
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework_simplejwt.authentication import JWTAuthentication, JWTTokenUserAuthentication

from .models import *
from .serializers import *


class UserCreateView(CreateAPIView):
    serializer_class = UserCreateSerializer


# class UserListView(ListAPIView):
#     serializer_class = UsetSerializer
#     queryset = User.objects.all()


# class UserDetailView(RetrieveUpdateDestroyAPIView):
#     serializer_class = UsetSerializer
#     queryset = User.objects.all()


class UserSettingsUpdateView(UpdateAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    queryset = UserSettings.objects.all()
    serializer_class = UserSettingsSerializer
    user_id = None

    def put(self, request, *args, **kwargs):
        user,  validated_token = self.authenticate(request)
        self.user_id = user.pk
        return self.update(request, *args, **kwargs)

    def get_object(self):
        queryset = self.filter_queryset(self.get_queryset())

        filter_kwargs = {'user_id': self.user_id}
        obj = get_object_or_404(queryset, **filter_kwargs)
        self.check_object_permissions(self.request, obj)

        return obj


class SocialMediaPublicCreateView(CreateAPIView):
    serializer_class = SocialMediaPublicSerializer
    queryset = SocialMediaPublic.objects.all()
    permission_classes = [IsAuthenticated]

    def create(self, request, *args, **kwargs):
        serializer = SocialMediaPublicSerializer(data=request.data, many=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)



# class SubscribesCreateView(CreateAPIView):
#     serializer_class = SubscribesSerializer
