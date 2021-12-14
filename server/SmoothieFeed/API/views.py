from drf_yasg.utils import swagger_auto_schema
from rest_framework.generics import ListAPIView
from .serializers import *


@swagger_auto_schema()
class DetoxLevelView(ListAPIView):
    serializer_class = DetoxLevelSerializer
    queryset = DetoxLevel.objects.all()
