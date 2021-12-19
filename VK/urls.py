from django.urls import path

from .views import *

urlpatterns = [
    path('news/', NewsVKView.as_view()),
]