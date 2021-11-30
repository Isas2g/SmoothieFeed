from rest_framework.generics import ListAPIView
from .serializers import *


class DetoxLevelView(ListAPIView):
    serializer_class = DetoxLevelSerializer
    queryset = DetoxLevel.objects.all()
