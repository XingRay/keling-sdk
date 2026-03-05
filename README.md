# Keling SDK (Kotlin)

中文 | English

---

## 中文说明

### 项目简介

这是一个基于 Kotlin 的 Keling SDK，封装了图像、视频、虚拟试穿、音频、账号等 API，提供统一客户端 `KelingClient`。

### 环境要求

- JDK 17+
- Gradle
- Kotlin 2.1+

### 依赖引入

#### 通过 JitPack 引入

**Gradle (Kotlin DSL)**

在项目根目录的 `settings.gradle.kts` 中添加 JitPack 仓库：

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

在模块的 `build.gradle.kts` 中添加依赖：

```kotlin
dependencies {
    implementation("com.github.XingRay:keling-sdk:0.0.1")
}
```

> **提示**：将 `0.0.1` 替换为最新的版本号或使用 Git 标签/提交哈希。查看可用版本：https://jitpack.io/#XingRay/keling-sdk

#### 本地构建

```bash
gradle build
```

### 快速开始

```kotlin
import com.github.xingray.kelingsdk.KelingClient
import com.github.xingray.kelingsdk.auth.Credentials
import com.github.xingray.kelingsdk.support.TestFixtures

suspend fun demo() {
    val client = KelingClient()
    val credentials = Credentials("your-ak", "your-sk")

    val resp = client.text2Video.create(credentials, TestFixtures.text2VideoRequest())
    println(resp)

    client.close()
}
```

### 组合接口（提交 + 轮询）

已新增组合扩展接口，便于直接拿到任务最终状态：

- `createAndPollQuery(...)`
- `createSingleAndPollQuery(...)`
- `createDualAndPollQuery(...)`

示例：

```kotlin
val result = client.imageGeneration.createAndPollQuery(
    credentials = credentials,
    request = TestFixtures.imageGenerationRequest(),
    maxAttempts = 10,
    intervalMillis = 2000
)
println(result)
```

### 对象/数组响应兼容

SDK 已兼容 `data` 字段两种返回形态：

- `data: { ... }`
- `data: [ { ... } ]`

在 `TaskData` 反序列化层做了兼容处理，避免 `queryByExternalId` 等接口因返回数组导致反序列化报错。

### 集成测试

测试位于 `src/test/kotlin`，覆盖全部 API 类。

#### 测试环境变量

- `KLING_ACCESS_KEY`
- `KLING_SECRET_KEY`
- `KLING_BASE_URL`（可选）

#### 执行测试

```bash
gradle testClasses
gradle test
```

未配置 `KLING_ACCESS_KEY` / `KLING_SECRET_KEY` 时：

- 测试会跳过（不会失败）
- 会输出警告提示

### 测试输出

所有测试方法都会打印响应对象，便于观察：

- code/message/request_id
- task_id/task_status
- 生成结果中的图片/视频 URL（若接口返回）

---

## English

### Overview

This is a Kotlin SDK for Keling APIs, with a unified `KelingClient` covering image, video, try-on, audio, and account
endpoints.

### Requirements

- JDK 17+
- Gradle
- Kotlin 2.3+

### Installation

#### Via JitPack

**Gradle (Kotlin DSL)**

Add JitPack repository in your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add dependency in your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.XingRay:keling-sdk:0.0.1")
}
```

> **Tip**: Replace `0.0.1` with the latest version or use Git tags/commit hashes. Check available versions
> at: https://jitpack.io/#XingRay/keling-sdk

#### Local Build

```bash
gradle build
```

### Quick Start

```kotlin
import com.github.xingray.kelingsdk.KelingClient
import com.github.xingray.kelingsdk.auth.Credentials
import com.github.xingray.kelingsdk.support.TestFixtures

suspend fun demo() {
    val client = KelingClient()
    val credentials = Credentials("your-ak", "your-sk")

    val resp = client.text2Video.create(credentials, TestFixtures.text2VideoRequest())
    println(resp)

    client.close()
}
```

### Combined APIs (submit/create + poll query)

Polling extension APIs are added to get final task status more easily:

- `createAndPollQuery(...)`
- `createSingleAndPollQuery(...)`
- `createDualAndPollQuery(...)`

Example:

```kotlin
val result = client.imageGeneration.createAndPollQuery(
    credentials = credentials,
    request = TestFixtures.imageGenerationRequest(),
    maxAttempts = 10,
    intervalMillis = 2000
)
println(result)
```

### Object/Array response compatibility

The SDK now supports both response shapes for `data`:

- `data: { ... }`
- `data: [ { ... } ]`

Compatibility is implemented in `TaskData` deserialization, so external-id query APIs no longer fail on array-shaped
`data`.

### Integration Tests

Tests are under `src/test/kotlin` and cover all API classes.

#### Required env vars

- `KLING_ACCESS_KEY`
- `KLING_SECRET_KEY`
- `KLING_BASE_URL` (optional)

#### Run tests

```bash
gradle testClasses
gradle test
```

If `KLING_ACCESS_KEY` / `KLING_SECRET_KEY` are missing:

- tests are skipped (not failed)
- a warning is printed

### Test output

All test methods print response objects for observation, including:

- code/message/request_id
- task_id/task_status
- generated image/video URLs when available
