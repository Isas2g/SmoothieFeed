from django.urls import path

from .views import *

urlpatterns = [
    path('news/', NewsInstagramView.as_view()),
]