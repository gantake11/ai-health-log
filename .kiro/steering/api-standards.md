# API設計規約

プロジェクトにおけるAPIの命名、構造、認証、バージョニング、およびエラーハンドリングに関するガイドラインです。

## 哲学
- 予測可能でリソース指向のデザインを優先する
- コントラクトを明示的にし、破壊的変更を最小限に抑える
- デフォルトでセキュア（認証優先、最小権限）

## エンドポイントのパターン
```
/api/{version}/{resource}[/{id}][/{sub-resource}]
```
例:
- `/api/v1/users`
- `/api/v1/users/{id}`
- `/api/v1/daily-records`

HTTPメソッドの利用:
- **GET**: 取得（安全、冪等）
- **POST**: 作成
- **PUT**: 置換・更新
- **PATCH**: 部分更新
- **DELETE**: 削除（冪等）

## リクエストとレスポンス

リクエスト（典型例）:
- DTO（Data Transfer Object）を使用して入力を受け取る
- `@Valid` アノテーションによるバリデーションを実施

成功レスポンス（典型例）:
```json
{
  "data": { ... },
  "meta": {
    "timestamp": "2024-03-20T10:00:00Z",
    "requestId": "..."
  }
}
```

エラーレスポンス:
```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "入力内容に不備があります",
    "details": [
      { "field": "email", "message": "無効な形式です" }
    ]
  }
}
```

## ステータスコード
- **2xx**: 成功（200 OK, 201 Created, 204 No Content）
- **4xx**: クライアントエラー（400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found）
- **5xx**: サーバーエラー（500 Internal Server Error）

## 認証
- 標準的な `Authorization: Bearer {token}` ヘッダーを使用
- ビジネスロジックの前に認証・認可をチェックする

## バリデーション
- `jakarta.validation` アノテーションを使用（例: `@NotNull`, `@Size`, `@Email`）
- コントローラー層で `@Valid` を付与してリクエストを検証する

---
_このドキュメントはパターンと決定事項に焦点を当てています。エンドポイントのカタログではありません。_
