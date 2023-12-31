# Руководство по установке и использованию приложения Backend для корпоративного университета

## Описание

Данное приложение является Backend частью для корпоративного университета. Оно разработано на языке Java версии 17 и использует фреймворк Spring версии 3.1.4. Приложение также использует Docker для контейниризации и Docker Compose для управления контейнерами. Для документирования API используется Swagger.

## Установка

1. Склонируйте репозиторий приложения на свой локальный компьютер:

```bash
git clone https://git.codenrock.com/adventure-league-spb/cnrprod-team-60415/adventure-league-k1.git -b backend_models_v1
```

2. Установите Docker на свой компьютер, следуя инструкциям с официального сайта:

```bash
https://docs.docker.com/get-docker/
```

3. Установите Docker Compose на свой компьютер, следуя инструкциям с официального сайта:

```bash
https://docs.docker.com/compose/install/
```

## Использование

1. Перейдите в корневую папку приложения:

```bash
cd /backend
```

2. Запустите Docker Compose для запуска контейнеров:

```bash
docker-compose up 
```

## Настройки

Если вам необходимо изменить настройки приложения, вы можете отредактировать файл `application.properties`, который находится в папке `src/main/resources`. В этом файле вы можете изменить порт, учетные данные базы данных и другие настройки.

## Зависимости

- Java 17
- Spring 3.1.4
- Docker
- Docker Compose
- Swagger

## Автор

- Vladislavs