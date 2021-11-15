from django.contrib import admin
from django.contrib.admin import ModelAdmin, display
from .models import *

admin.site.unregister(User)


@admin.register(User)
class UserAdmin(ModelAdmin):
    list_display = ('id', 'username', 'email', 'last_login')
    # search_fields = ('email',)

    def save_model(self, request, obj, form, change):
        obj.set_password(obj.password)
        obj.save()
        user_settings = UserSettings(user=obj)
        user_settings.save()

        user_sources = UserSources(user=obj)
        user_sources.save()


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


@admin.register(Subscribes)
class SubscribesAdmin(ModelAdmin):
    list_display = ('id', 'get_public', 'get_user')

    @display(description='SocialMediaPublic')
    def get_public(self, obj):
        return obj.public

    @display(description='User')
    def get_user(self, obj):
        return obj.user


@admin.register(UserSettings)
class UserSettingsAdmin(ModelAdmin):
    list_display = ('id', 'detox_limit_post', 'detox_limit_time', 'get_user')

    @display(description='User')
    def get_user(self, obj):
        return obj.user


@admin.register(UserSources)
class UserSourcesAdmin(ModelAdmin):
    list_display = ('id', 'last_seen', 'total_seen_post', 'total_seen_time', 'get_user')

    @display(description='User')
    def get_user(self, obj):
        return obj.user


@admin.register(DetoxLevel)
class DetoxLevelAdmin(ModelAdmin):
    list_display = ('level', 'name', 'post', 'time')
