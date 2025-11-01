# Автотесты для FapHouse

Проект автоматизации тестирования веб-приложения FapHouse Studio с использованием Selenide, JUnit5 и Allure.

## Технологии

- **Java 11+**
- **Gradle** - система сборки
- **Selenide 7.5.1** - фреймворк для UI тестирования
- **JUnit 5** - тестовый фреймворк
- **Allure** - отчеты о тестировании
- **JavaFaker** - генерация тестовых данных
- **Owner** - управление конфигурацией
- **Lombok** - упрощение Java кода

## Структура проекта

```
src/test/java/
├── annotation/          # Кастомные аннотации для тестов
├── config/              # Конфигурация проекта
├── extension/           # JUnit5 расширения
├── model/               # Модели данных
├── pages/               # Page Object классы
└── tests/               # Тестовые классы

src/test/resources/
├── pics/                # Тестовые изображения для загрузки
├── project.properties   # Конфигурация окружения
└── junit-platform.properties
```

## Конфигурация

Настройки тестов находятся в `src/test/resources/project.properties`:

```properties
baseUrl=https://studio.faphouse.com/
browserSize=1920x1080
browser=chrome
headless=false
```

### Параметры конфигурации:

- `baseUrl` - базовый URL приложения
- `browserSize` - разрешение окна браузера
- `browser` - браузер для запуска (chrome, firefox, edge, safari)
- `headless` - режим без GUI (true/false)

## Запуск тестов

### Запуск всех веб-тестов

```bash
./gradlew web_test
```

### Кроссбраузерное тестирование

#### Chrome (по умолчанию)
```bash
./gradlew web_test
```

#### Firefox
```bash
./gradlew web_test -Dbrowser=firefox
```

#### Edge
```bash
./gradlew web_test -Dbrowser=edge
```

#### Safari
```bash
./gradlew web_test -Dbrowser=safari
```

#### Headless режим
```bash
./gradlew web_test -Dheadless=true
```

#### Комбинированные параметры
```bash
./gradlew web_test -Dbrowser=firefox -Dheadless=true -DbrowserSize=1280x720
```

### Запуск всех тестов
```bash
./gradlew test
```

### Запуск с очисткой предыдущих результатов
```bash
./gradlew clean web_test
```

## Allure отчеты

### Генерация отчета после прогона тестов

```bash
./gradlew allureReport
```

### Открыть отчет в браузере

```bash
./gradlew allureServe
```

Отчет автоматически откроется в браузере по адресу `http://localhost:порт`

## Тестовые сценарии

### Негативный тест регистрации
Проверяет валидацию формы при отправке без загрузки обязательных документов.

### Позитивный тест регистрации
Полный цикл регистрации бизнес-аккаунта:
1. Регистрация пользователя
2. Выбор типа аккаунта "Бизнес"
3. Заполнение данных компании
4. Принятие соглашений
5. Загрузка документов
6. Завершение регистрации
7. Удаление тестового аккаунта

## Особенности реализации

- **Page Object Model** - паттерн организации страниц
- **Fluent API** - цепочка вызовов методов
- **Random Test Data** - генерация случайных данных через JavaFaker
- **Custom Extensions** - расширения JUnit5 для управления браузером и данными
- **Allure Steps** - детальная отчетность по шагам теста
- **Smart Waits** - автоматические ожидания элементов (30 секунд)

## Требования

- **Java JDK 11** или выше
- **Gradle 7+** (включен Gradle Wrapper)
- Установленные браузеры для тестирования

## Установка и первый запуск

```bash
# Клонируйте репозиторий
git clone <repository-url>
cd test-task-fap

# Запустите тесты
./gradlew web_test

# Сгенерируйте отчет
./gradlew allureServe
```

## CI/CD

Проект готов к интеграции в CI/CD пайплайны. Пример команды для Jenkins/GitLab CI:

```bash
./gradlew clean web_test -Dbrowser=chrome -Dheadless=true
./gradlew allureReport
```

## Troubleshooting

**Проблема:** Тесты падают с ошибкой "element not found"
**Решение:** Увеличьте таймаут в `TestBase.java`: `Configuration.timeout = 60_000;`

**Проблема:** Браузер не открывается
**Решение:** Проверьте установку браузера и WebDriver (Selenide загружает драйверы автоматически)

**Проблема:** Headless режим работает некорректно
**Решение:** Некоторые браузеры (Safari) не поддерживают headless, используйте Chrome или Firefox

## Контакты

При возникновении вопросов или проблем создайте issue в репозитории.

