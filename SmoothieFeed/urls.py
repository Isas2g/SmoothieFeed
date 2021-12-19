from django.contrib import admin
from django.urls import path, include
from .yasg import urlpatterns as doc_urls


urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/v1/', include('API.urls')),
    path('api/v1/user/', include('user.urls')),
    path('api/v1/social_media/', include('social_media.urls')),
]

urlpatterns += doc_urls