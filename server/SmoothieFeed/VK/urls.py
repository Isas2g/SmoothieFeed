from django.urls import path

from .views import *

urlpatterns = [
    path('news/', AuthVK.as_view()),
]