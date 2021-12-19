from rest_framework.serializers import ModelSerializer
from .models import *


class SocialMediaSerializer(ModelSerializer):
    class Meta:
        model = SocialMedia
        fields = '__all__'


class SocialMediaPublicSerializer(ModelSerializer):
    media = SocialMediaSerializer()

    class Meta:
        model = SocialMediaPublic
        fields = ('media', 'public_id')
