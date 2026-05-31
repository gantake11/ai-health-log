# 技術スタック

## アーキテクチャ

プロジェクトは標準的なマルチティアアーキテクチャを採用しており、Vue.jsフロントエンド、Spring Boot REST/MVCバックエンド、およびMySQLリレーショナルデータベースが明確に分離されています。アプリケーション全体はDocker Composeを使用してコンテナ化されており、一貫した開発およびデプロイ環境を提供します。

## コア技術

- **フロントエンド**: Vue 3 (Composition API, TypeScript) + Vite
- **バックエンド**: Java 21, Spring Boot 3.5.x
- **データベース**: MySQL 8.0
- **インフラ**: Docker & Docker Compose

## 主要ライブラリ

- **Spring Data JPA / Hibernate**: ORMおよびデータベース操作。
- **Spring Security**: アプリケーションのセキュリティと認証。
- **Flyway**: データベースマイグレーションとバージョン管理。
- **Thymeleaf**: バックエンドでのSSR（サーバーサイドレンダリング）ビュー/テンプレート。
- **Lombok**: Javaにおけるボイラープレートコードの削減。

## 開発標準

### 型安全性
- フロントエンドでの厳格なTypeScriptの使用。
- Java 21による強力な静的型付け。

### アーキテクチャパターン (バックエンド)
- レイヤードアーキテクチャ: Controller, Service, Repository, Entity, DTO (`com.example.demo`)。

### テスト
- バックエンドのユニットテストおよび統合テスト用の `spring-boot-starter-test` と `spring-security-test`。

## 開発環境

### 必須ツール
- Docker & Docker Compose
- Node.js & npm (ローカルフロントエンド開発用)
- Java 21 & Maven (ローカルバックエンド開発用)

### 共通コマンド
```bash
# フルスタック起動 (Docker)
docker compose up --build

# フロントエンド・ローカル開発 (ホットリロードあり)
cd frontend
npm install && npm run dev
```

## 主要な技術決定

- **コンテナファースト開発**: Docker Composeを使用することで、スタック全体に対して（Docker以外の）依存関係をインストールすることなくセットアップが可能です。
- **データベースマイグレーション**: Flywayを使用して、すべてのデータベーススキーマ変更がバージョン管理され、再現可能で、コードベースと同期されるようにします。
