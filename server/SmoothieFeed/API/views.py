from rest_framework import mixins, viewsets, status
from rest_framework.generics import (CreateAPIView,
                                     ListAPIView,
                                     RetrieveUpdateAPIView,
                                     UpdateAPIView,
                                     RetrieveAPIView,
                                     RetrieveUpdateAPIView, ListCreateAPIView, get_object_or_404
                                     )
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response
from rest_framework.viewsets import GenericViewSet

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


class UserSettingsRetrieveUpdateView(RetrieveUpdateAPIView, JWTTokenUserAuthentication):
    # permission_classes = [IsAuthenticated]
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


class SocialMediaView(ListAPIView):
    serializer_class = SocialMediaSerializer
    queryset = SocialMedia.objects.all()


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
                serializer.save()
                data.append(i)
        if errors:
            detail = {**errors, **{'save': data}}
            return Response(detail, status=status.HTTP_400_BAD_REQUEST)
        return Response(data, status=status.HTTP_201_CREATED)
        # serializer = self.get_serializer(data=request.data, many=True)
        # serializer.is_valid(raise_exception=True)
        # self.perform_create(serializer)
        # headers = self.get_success_headers(serializer.data)
        # return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)


class SubscribesListCreateView(ListCreateAPIView, JWTTokenUserAuthentication):
    permission_classes = [IsAuthenticated]
    queryset = Subscribes.objects.all()
    serializer_class = SubscribesSerializer

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
                serializer.save()
                data.append(i)
        if errors:
            detail = {**errors, **{'save': data}}
            return Response(detail, status=status.HTTP_400_BAD_REQUEST)
        return Response(data, status=status.HTTP_201_CREATED)

    def get(self, request, *args, **kwargs):
        self.user_id = self.authenticate(request)[0].pk
        return self.list(request, *args, **kwargs)

    def filter_queryset(self, queryset):
        return queryset.filter(user_id=self.user_id)


class DetoxLevelView(ListAPIView):
    serializer_class = DetoxLevelSerializer
    queryset = DetoxLevel.objects.all()
