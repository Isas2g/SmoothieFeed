from django.db.models import Model, CharField


class SocialMedia(Model):
    name = CharField(
        max_length=64,
        unique=True,
        verbose_name='имя'
    )

    class Meta:
        db_table = 'social_media'
        verbose_name = 'Социальна сеть'
        verbose_name_plural = 'Социальные сети'

    def __str__(self):
        return self.name