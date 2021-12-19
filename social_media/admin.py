from django.contrib import admin
from django.contrib.admin import ModelAdmin, display
from .models import *


@admin.register(SocialMedia)
class SocialMediaAdmin(ModelAdmin):
    list_display = ('id', 'name')
    list_display_links = ('name',)


@admin.register(SocialMediaPublic)
class SocialMediaPublic(ModelAdmin):
    list_display = ('id', 'get_media', 'public_id')

    @display(ordering='media__name', description='SocialMedia')
    def get_media(self, obj):
        return obj.media