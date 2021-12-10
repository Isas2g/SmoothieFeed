from django.urls import path, include

from .views import *

urlpatterns = [
    path('', UserCreateView.as_view()),
    path('sources/', UserSourcesRetrieveUpdateView.as_view()),
    path('settings/', UserSettingsRetrieveUpdateView.as_view()),
    path('subscribes/', SubscribesListCreateView.as_view()),
    path('social_media/', UserUseSocialMediaView.as_view()),
    path('social_media/vk/', include('VK.urls')),
    path('social_media/instagram/', include('Instagram.urls')),
]
