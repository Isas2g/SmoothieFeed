from django.urls import path

from .views import *

urlpatterns = [
    path('', UserCreateView.as_view()),
    path('settings/', UserSettingsRetrieveUpdateView.as_view()),
    path('subscribes/', SubscribesListCreateView.as_view()),
    path('social_media/', UserUseSocialMediaView.as_view()),
]
