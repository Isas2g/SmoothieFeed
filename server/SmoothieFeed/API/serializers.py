from rest_framework.serializers import ModelSerializer

from .models import *


class DetoxLevelSerializer(ModelSerializer):
    class Meta:
        model = DetoxLevel
        fields = (
            'level',
            'name',
            'post',
            'time',
        )



