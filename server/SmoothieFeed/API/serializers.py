from datetime import timedelta
from time import time

from rest_framework.serializers import ModelSerializer

from .models import *


class UsetSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = (
            'id',
            'last_login',
            'username',
            'email',
            'date_joined',
        )


class UserCreateSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = ('id', 'email', 'username', 'password')
        extra_kwargs = {'password': {'write_only': True}}

    def create(self, validated_data):
        user = User(
            email=validated_data['email'],
            username=validated_data['username']
        )
        user.set_password(validated_data['password'])
        user.save()

        user_settings = UserSettings(user=user)
        user_settings.save()

        user_sources = UserSources(user=user)
        user_sources.save()
        return user


class UserSettingsSerializer(ModelSerializer):
    class Meta:
        model = UserSettings
        fields = (
            'detox_limit_post',
            'detox_limit_time',
        )


class SocialMediaPublicSerializer(ModelSerializer):
    class Meta:
        model = SocialMediaPublic
        fields = '__all__'
