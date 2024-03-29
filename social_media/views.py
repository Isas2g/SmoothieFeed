from rest_framework import status
from rest_framework.generics import ListAPIView, CreateAPIView
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response

from .serializers import *


class SocialMediaView(ListAPIView):
    serializer_class = SocialMediaSerializer
    queryset = SocialMedia.objects.all()


class SocialMediaPublicCreateView(CreateAPIView):
    permission_classes = [IsAuthenticated]
    serializer_class = SocialMediaPublicSerializer
    queryset = SocialMediaPublic.objects.all()

    def create(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data, many=True)
        serializer.is_valid(raise_exception=True)
        self.perform_create(serializer)
        headers = self.get_success_headers(serializer.data)
        return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)