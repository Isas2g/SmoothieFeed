from django.db import IntegrityError
from rest_framework.serializers import ModelSerializer, raise_errors_on_nested_writes, CharField
from rest_framework_simplejwt.authentication import JWTTokenUserAuthentication

from .models import *
from social_media.serializers import SocialMediaSerializer


class UserRetrieveSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = ('id', 'email', 'username')


class UserCreateSerializer(ModelSerializer):
    password = CharField(write_only=True)

    class Meta:
        model = User
        fields = ('id', 'email', 'username', 'password')

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


class UserSourcesSerializer(ModelSerializer):
    class Meta:
        model = UserSources
        fields = (
            'seen_last',
            'total_seen_post',
            'total_seen_time',
        )


class UserSettingsSerializer(ModelSerializer):
    class Meta:
        model = UserSettings
        fields = (
            'detox_limit_post',
            'detox_limit_time',
        )


class UserUseSocialMediaSerializer(ModelSerializer, JWTTokenUserAuthentication):
    media = SocialMediaSerializer()

    class Meta:
        model = UserUseSocialMedia
        fields = (
            'media',
            'token'
        )

    def create(self, validated_data):
        user_id = self.authenticate(self.context['request'])[0].pk
        user = User.objects.get(id=user_id)
        use = UserUseSocialMedia(
            user=user,
            media=validated_data['media'],
            token=validated_data['token'],
        )
        use.save()
        return use


class SubscribesSerializer(ModelSerializer, JWTTokenUserAuthentication):

    class Meta:
        model = Subscribes
        fields = ('public',)

    def create(self, validated_data):
        user_id = self.authenticate(self.context['request'])[0].pk
        user = User.objects.get(id=user_id)
        validated_data["user"] = user

        sub = super().create(validated_data)

        return sub