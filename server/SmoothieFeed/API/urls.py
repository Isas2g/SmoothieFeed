from django.urls import path
from .views import *

urlpatterns = [
    # path('users/', UserListView.as_view()),
    # path('users/<int:pk>/', UserDetailView.as_view()),
    path('users/create/', UserCreateView.as_view()),
    path('users/settings/', UserSettingsRetrieveUpdateView.as_view()),
    path('users/subscibes/', SubscribesListCreateView.as_view()),
    path('detox_levels/', DetoxLevelView.as_view()),
    path('social_media/', SocialMediaView.as_view()),
    path('social_media/public/create/', SocialMediaPublicCreateView.as_view()),
]