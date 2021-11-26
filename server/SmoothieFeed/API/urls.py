from django.urls import path
from .views import *
from .yasg import urlpatterns as doc_urls

urlpatterns = [
    # path('users/', UserListView.as_view()),
    # path('users/<int:pk>/', UserDetailView.as_view()),
    path('user/create/', UserCreateView.as_view()),
    path('user/settings/', UserSettingsRetrieveUpdateView.as_view()),
    path('user/subscibes/', SubscribesListCreateView.as_view()),
    path('user/social_media/', UserUseSocialMediaView.as_view()),
    path('detox_levels/', DetoxLevelView.as_view()),
    path('social_media/', SocialMediaView.as_view()),
    path('social_media/publics/', SocialMediaPublicCreateView.as_view()),
]

urlpatterns += doc_urls
