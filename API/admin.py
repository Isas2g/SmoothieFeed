from django.contrib import admin
from django.contrib.admin import ModelAdmin
from .models import *


@admin.register(DetoxLevel)
class DetoxLevelAdmin(ModelAdmin):
    list_display = ('level', 'name', 'post', 'time')
