from django.contrib import admin
from django.contrib.admin import ModelAdmin, display

from .models import *

admin.site.unregister(User)


@admin.register(User)
class UserAdmin(ModelAdmin):
    list_display = ('id', 'username', 'email', 'last_login')

    def save_model(self, request, obj, form, change):
        obj.set_password(obj.password)
        obj.save()
        user_settings = UserSettings(user=obj)
        user_settings.save()

        user_sources = UserSources(user=obj)
        user_sources.save()


@admin.register(UserSettings)
class UserSettingsAdmin(ModelAdmin):
    list_display = ('id', 'detox_limit_post', 'detox_limit_time', 'get_user')

    @display(description='User')
    def get_user(self, obj):
        return obj.user


@admin.register(UserSources)
class UserSourcesAdmin(ModelAdmin):
    list_display = ('id', 'seen_last', 'total_seen_post', 'total_seen_time', 'get_user')

    @display(description='User')
    def get_user(self, obj):
        return obj.user


@admin.register(Subscribes)
class SubscribesAdmin(ModelAdmin):
    list_display = ('id', 'get_public', 'get_user')

    @display(description='SocialMediaPublic')
    def get_public(self, obj):
        return obj.public

    @display(description='User')
    def get_user(self, obj):
        return obj.user
