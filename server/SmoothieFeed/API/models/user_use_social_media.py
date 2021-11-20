from django.db.models import Model, ForeignKey, CharField, CASCADE, IntegerField
from django.contrib.auth.models import User

from .social_media import SocialMedia


class UserUseSocialMedia(Model):
    user = ForeignKey(User, on_delete=CASCADE)
    media = ForeignKey(SocialMedia, on_delete=CASCADE)

    class Meta:
        db_table = 'API_user_use_social_media'
        verbose_name = 'Юзер использует социальыне сети'
        verbose_name_plural = 'Юзеры используют социальыне сети'
        unique_together = ('user', 'media')

    def __str__(self):
        return f"{self.user}: {self.media}"


