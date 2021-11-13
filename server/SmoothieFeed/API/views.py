from rest_framework import mixins, viewsets, status
from rest_framework.generics import (CreateAPIView,
                                     ListAPIView,
                                     RetrieveUpdateDestroyAPIView,
                                     UpdateAPIView,
                                     RetrieveAPIView,
                                     RetrieveUpdateAPIView, ListCreateAPIView, get_object_or_404
                                     )
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response

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
        user, validated_token = self.authenticate(request)
        self.user_id = user.pk
        return self.update(request, *args, **kwargs)

    def get_object(self):
        queryset = self.filter_queryset(self.get_queryset())

        filter_kwargs = {'user_id': self.user_id}
        obj = get_object_or_404(queryset, **filter_kwargs)
        self.check_object_permissions(self.request, obj)

        return obj


class SocialMediaPublicCreateView(CreateAPIView):
    permission_classes = [IsAuthenticated]
    serializer_class = SocialMediaPublicSerializer
    queryset = SocialMediaPublic.objects.all()

    def create(self, request, *args, **kwargs):
        data = []
        errors = {}
        request_data = request.data if isinstance(request.data, list) else [request.data]
        for i in request_data:
            serializer = self.get_serializer(data=i)
            serializer.is_valid()
            error_flag = False
            for j in serializer.errors:
                errors[j] = list(set(errors.get(j, []) + serializer.errors[j]))
                error_flag = True
            if not error_flag:
                data.append(i)
        if errors:
            detail = {**errors, **{'save': data}}
            return Response(detail, status=status.HTTP_400_BAD_REQUEST)
        return Response(data, status=status.HTTP_201_CREATED)


class SubscribesCreateView(CreateAPIView):
    permission_classes = [IsAuthenticated]
    queryset = User.objects.all()
    serializer_class = SubscribesSerializer

    user_id = None

    def create(self, request, *args, **kwargs):
        data = []
        errors = {}
        request_data = request.data if isinstance(request.data, list) else [request.data]
        for i in request_data:
            serializer = self.get_serializer(data=i)
            serializer.is_valid()
            error_flag = False
            for j in serializer.errors:
                errors[j] = list(set(errors.get(j, []) + serializer.errors[j]))
                error_flag = True
            if not error_flag:
                data.append(i)
        if errors:
            detail = {**errors, **{'save': data}}
            return Response(detail, status=status.HTTP_400_BAD_REQUEST)
        return Response(data, status=status.HTTP_201_CREATED)


class DetoxLevelView(ListAPIView):
    serializer_class = DetoxLevelSerializer
    queryset = DetoxLevel.objects.all()

