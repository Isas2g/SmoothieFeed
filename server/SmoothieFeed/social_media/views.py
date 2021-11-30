from rest_framework import status
from rest_framework.generics import ListAPIView, CreateAPIView
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response

from .serializers import *


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
                try:
                    serializer.save()
                except Exception as e:
                    pass
                data.append(i)
        if errors:
            detail = {**errors, **{'save': data}}
            return Response(detail, status=status.HTTP_400_BAD_REQUEST)
        return Response(data, status=status.HTTP_201_CREATED)
