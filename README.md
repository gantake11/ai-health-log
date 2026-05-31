# AI Health Log

このプロジェクトは、健康管理を目的としたWebアプリケーションです。
フロントエンドに Vue.js (TypeScript + Vite)、バックエンドに Spring Boot を使用しています。

## フォルダ構成

- `backend/`: Spring Boot (Java 21) プロジェクト
- `frontend/`: Vue.js (TypeScript) プロジェクト
- `docker-compose.yml`: 全サービス（フロント・バック・DB）の構成管理

## 実行方法

### 事前準備
- Docker および Docker Compose がインストールされていること。

### 起動手順
プロジェクトのルートディレクトリで以下のコマンドを実行してください。

```bash
docker-compose up --build
```

### アクセス情報
- **フロントエンド**: [http://localhost:5173](http://localhost:5173)
- **バックエンド API**: [http://localhost:8080](http://localhost:8080)
- **データベース**: `localhost:3307` (MySQL)
  - ユーザー名: `ai-health-log`
  - パスワード: `ai-health-log`
  - データベース名: `ai-health-log_db`

## 開発ガイド

### バックエンドの変更
`backend/src` 内のコードを変更した場合は、`docker compose up --build` を実行して再ビルドしてください。

### フロントエンドの変更
`frontend/src` 内のコードを変更した場合は、Dockerコンテナ内のビルドに反映させるために再ビルドが必要です。
※ローカル開発時は `frontend` ディレクトリで `npm install && npm run dev` を実行してホットリロードを利用することも可能です。

## データベースのマイグレーション
Flyway を使用してデータベースのマイグレーションを自動管理しています。
SQLファイルは `backend/src/main/resources/db/migration` に配置してください。
