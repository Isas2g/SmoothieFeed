from django.urls import path, include

from .views import *

urlpatterns = [
    path('', SocialMediaView.as_view()),
    path('publics/', SocialMediaPublicCreateView.as_view()),
]
