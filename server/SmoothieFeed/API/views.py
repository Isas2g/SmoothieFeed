from rest_framework import mixins, viewsets, status
from rest_framework.generics import (CreateAPIView,
                                     ListAPIView,
                                     RetrieveUpdateDestroyAPIView,
                                     UpdateAPIView,
                                     RetrieveAPIView,
                                     RetrieveUpdateAPIView, ListCreateAPIView,
                                     )
from rest_framework.response import Response
from rest_framework.views import APIView

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


# class UserSettingsUpdateView(UpdateAPIView):
#     serializer_class = UserSettingsSerializer
#     queryset = UserSettings.objects.all()
#     lookup_field = 'user_id'


class SocialMediaPublicCreateView(CreateAPIView):
    serializer_class = SocialMediaPublicSerializer
    queryset = SocialMediaPublic.objects.all()

    def create(self, request, *args, **kwargs):
        serializer = SocialMediaPublicSerializer(data=request.data, many=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)



# class SubscribesCreateView(CreateAPIView):
#     serializer_class = SubscribesSerializer
