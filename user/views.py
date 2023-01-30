from rest_framework import status
from rest_framework.generics import RetrieveAPIView, CreateAPIView, RetrieveUpdateAPIView, \
    get_object_or_404, ListCreateAPIView, DestroyAPIView, UpdateAPIView
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response

from .serializers import *


class UserCreateView(CreateAPIView):
    serializer_class = UserCreateSerializer


class UserRetrieveView(RetrieveAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    serializer_class = UserRetrieveSerializer
    queryset = User.objects.all()
    lookup_field = 'id'

    def get(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.retrieve(request, *args, **kwargs)

    def get_object(self):
        queryset = self.filter_queryset(self.get_queryset())

        filter_kwargs = {'id': self.user_id}
        obj = get_object_or_404(queryset, **filter_kwargs)
        self.check_object_permissions(self.request, obj)
        return obj


class UserSourcesRetrieveUpdateView(RetrieveUpdateAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    queryset = UserSources.objects.all()
    serializer_class = UserSourcesSerializer
    lookup_field = 'user_id'

    def put(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.update(request, *args, **kwargs)

    def get(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.retrieve(request, *args, **kwargs)

    def get_object(self):
        queryset = self.filter_queryset(self.get_queryset())

        filter_kwargs = {'user_id': self.user_id}
        obj = get_object_or_404(queryset, **filter_kwargs)
        self.check_object_permissions(self.request, obj)
        return obj


class UserSettingsRetrieveUpdateView(RetrieveUpdateAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    queryset = UserSettings.objects.all()
    serializer_class = UserSettingsSerializer
    user_id = None
    lookup_field = 'user_id'

    def put(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.update(request, *args, **kwargs)

    def get(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.retrieve(request, *args, **kwargs)

    def get_object(self):
        queryset = self.filter_queryset(self.get_queryset())

        filter_kwargs = {'user_id': self.user_id}
        obj = get_object_or_404(queryset, **filter_kwargs)
        self.check_object_permissions(self.request, obj)
        return obj


class UserUseSocialMediaView(ListCreateAPIView, UpdateAPIView, DestroyAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    queryset = UserUseSocialMedia.objects.all()
    user_id = None
    lookup_field = 'user_id'

    def create(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        self.perform_create(serializer)
        headers = self.get_success_headers(serializer.data)
        return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)

    def get_serializer_class(self):
        if self.request.method == 'GET':
            return UserUseSocialMediaReadSerializer
        elif self.request.method in ('POST', 'PUT', 'PATCH'):
            return UserUseSocialMediaWriteSerializer

    def filter_queryset(self, queryset):
        self.user_id = self.authenticate(self.request)[0].pk
        return queryset.filter(user_id=self.user_id)

    def get_object(self):
        queryset = self.filter_queryset(self.get_queryset())

        user_social_media_id = self.request.data['media']
        user_social_media = SocialMedia.objects.get(id=user_social_media_id)

        filter_kwargs = {'media': user_social_media}
        obj = get_object_or_404(queryset, **filter_kwargs)
        self.check_object_permissions(self.request, obj)
        return obj


class SubscribesListCreateView(ListCreateAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    queryset = Subscribes.objects.all()
    serializer_class = SubscribesSerializer

    def create(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data, many=True)
        serializer.is_valid(raise_exception=True)
        self.perform_create(serializer)
        headers = self.get_success_headers(serializer.data)
        return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)

    def get(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.list(request, *args, **kwargs)

    def filter_queryset(self, queryset):
        return queryset.filter(user_id=self.user_id)
