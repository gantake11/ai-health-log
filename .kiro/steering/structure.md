# プロジェクト構造

## 組織の哲学

プロジェクトはフルスタックモノレポとして構成されており、フロントエンドアプリケーションとバックエンドサービスを明確にトップレベルのディレクトリに分離しています。バックエンドは伝統的なレイヤードアーキテクチャ（Controller-Service-Repository）に従い、フロントエンドはVueのシングルページアプリケーション（SPA）として構成されています。

## ディレクトリパターン

### バックエンド・アプリケーション
**場所**: `/backend/src/main/java/com/example/demo/`  
**目的**: Spring Bootアプリケーションのコア。
- `controller/`: REST APIエンドポイントとWebリクエストハンドラ。
- `service/`: コアビジネスロジックとトランザクション管理。
- `repository/`: データアクセスのためのSpring Data JPAインターフェース。
- `entity/`: データベーステーブルを表すJPAエンティティ。
- `dto/`: APIのリクエスト/レスポンス用のデータ転送オブジェクト。
- `config/`: Spring Boot設定クラス（Security, CORSなど）。

### バックエンド・リソースとマイグレーション
**場所**: `/backend/src/main/resources/`  
**目的**: アプリケーション設定とデータベースマイグレーション。
- `db/migration/`: Flyway SQLマイグレーションスクリプト。
- `application.yml`: Spring Boot設定プロパティ。

### フロントエンド・アプリケーション
**場所**: `/frontend/src/`  
**目的**: Vue 3 SPAソースコード。
- `components/`: 再利用可能なUIコンポーネント。
- `assets/`: 画像やグローバルCSSなどの静的アセット。

## 命名規則

- **Javaクラス**: PascalCase (例: `SpringDemoApplication`, `UserController`)。
- **Vueコンポーネント**: PascalCase (例: `HelloWorld.vue`)。
- **データベースマイグレーション**: `V{Version}__{Description}.sql` (例: `V001__create_tables.sql`)。
- **フロントエンド・ファイル (コンポーネント以外)**: kebab-case または camelCase (例: `main.ts`, `style.css`)。

## コード組織の原則

- **関心の分離**: ビジネスロジックはバックエンドの `service` レイヤー内に厳密に閉じ込められます。ControllerはHTTPルーティングとバリデーションのみを担当します。
- **データベースファーストのスキーマ管理**: スキーマはHibernateによる自動生成ではなく、Flywayマイグレーションを通じて明示的に定義されます。
