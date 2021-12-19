from django.db.models import Model, ForeignKey, CharField, CASCADE
from django.contrib.auth.models import User
from social_media.models import SocialMedia


class UserUseSocialMedia(Model):
    user = ForeignKey(User, on_delete=CASCADE)
    media = ForeignKey(SocialMedia, on_delete=CASCADE)
    token = CharField(max_length=200, unique=True)

    class Meta:
        db_table = 'user_use_social_media'
        verbose_name = 'Юзер использует социальные сети'
        verbose_name_plural = 'Юзеры используют социальные сети'
        unique_together = ('user', 'media')

    def __str__(self):
        return f"{self.user}: {self.media}"


