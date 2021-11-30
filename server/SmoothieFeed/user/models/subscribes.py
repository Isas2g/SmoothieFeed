from django.contrib.auth.models import User
from django.db.models import Model, ForeignKey, CASCADE
from social_media.models import SocialMediaPublic


class Subscribes(Model):
    user = ForeignKey(User, on_delete=CASCADE)
    public = ForeignKey(SocialMediaPublic, on_delete=CASCADE)

    class Meta:
        db_table = 'user_subscribes'
        verbose_name = 'Подписка'
        verbose_name_plural = 'Подписки'
        unique_together = ('user', 'public')



