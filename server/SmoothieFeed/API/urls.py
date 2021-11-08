from django.urls import path
from .views import *

urlpatterns = [
    # path('users/', UserListView.as_view()),
    path('users/create/', UserCreateView.as_view()),
    # path('users/<int:pk>/', UserDetailView.as_view()),
    # path('users/<int:pk>/check_password', UserDetailView.as_view()),
    # path('users/<int:user_id>/settings/', UserSettingsUpdateView.as_view()),
    # path('users/<int:user_id>/subscibes/create/', SubscribesCreateView.as_view()),
    path('social_media/public/create/', SocialMediaPublicCreateView.as_view()),
]