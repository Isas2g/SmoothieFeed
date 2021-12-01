from rest_framework.serializers import ModelSerializer
from rest_framework_simplejwt.authentication import JWTTokenUserAuthentication

from .models import *
from social_media.serializers import SocialMediaSerializer


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


class UserUseSocialMediaSerializer(ModelSerializer, JWTTokenUserAuthentication):
    media = SocialMediaSerializer

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
        sub = Subscribes(
            user=user,
            public=validated_data['public']
        )
        sub.save()
        return sub