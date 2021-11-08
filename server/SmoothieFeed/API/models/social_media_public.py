from django.db.models import Model, ForeignKey, CharField, CASCADE
from .social_media import SocialMedia


class SocialMediaPublic(Model):
    media = ForeignKey(SocialMedia, on_delete=CASCADE)
    name = CharField(max_length=200, unique=True)

    class Meta:
        db_table = 'API_social_media_public'
        verbose_name = 'Паблик из социальной сети'
        verbose_name_plural = 'Паблики из социальной сети'

    def __str__(self):
        return self.name
