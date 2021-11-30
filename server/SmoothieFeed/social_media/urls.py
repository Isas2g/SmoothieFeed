from django.urls import path

from .views import *

urlpatterns = [
    path('', SocialMediaView.as_view()),
    path('publics/', SocialMediaPublicCreateView.as_view()),
]
