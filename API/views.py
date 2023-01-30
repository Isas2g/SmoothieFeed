from drf_yasg.utils import swagger_auto_schema
from rest_framework.generics import ListAPIView
from .serializers import *


class DetoxLevelView(ListAPIView):
    serializer_class = DetoxLevelSerializer
    queryset = DetoxLevel.objects.all()
