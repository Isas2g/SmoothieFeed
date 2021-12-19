from django.db.models import Model, ForeignKey, CASCADE, IntegerField
from .social_media import SocialMedia


class SocialMediaPublic(Model):
    media = ForeignKey(SocialMedia, on_delete=CASCADE)
    public_id = IntegerField()

    class Meta:
        db_table = 'social_media_public'
        verbose_name = 'Паблик из социальной сети'
        verbose_name_plural = 'Паблики из социальной сети'
        unique_together = ('media', 'public_id')

    def __str__(self):
        return f"{self.media}: {self.public_id}"


