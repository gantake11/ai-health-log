# Vue.js 開発規約

プロジェクトにおける Vue 3、TypeScript、Vite を使用したフロントエンド開発のガイドラインです。

## 哲学
- **Composition API**: 原則として `script setup` 構文を使用した Composition API を採用する
- **TypeScript**: 型安全性を重視し、インターフェースや型定義を明示的に行う
- **SFC (Single File Components)**: コンポーネントのロジック、テンプレート、スタイルを一つの `.vue` ファイルに集約する

## コンポーネント設計
- **配置**: `src/components/` に配置する。機能ごとにサブディレクトリを作成してもよい
- **命名**: `PascalCase` を使用する（例: `RecordList.vue`, `UserAvatar.vue`）
- **責務**:
    - UIコンポーネント: 見た目と再利用性を重視。ビジネスロジックを持たせない
    - ページコンポーネント: `App.vue` や主要な画面単位。データ取得や状態管理の橋渡しを行う

## スタイル
- **Scoped CSS**: 原則として `<style scoped>` を使用してスタイルの影響範囲を限定する
- **CSS設計**: 共通の変数やミックスインは `src/assets/` に集約し、グローバルでインポートする

## 状態管理
- シンプルな状態は `ref` / `reactive` でコンポーネント内に閉じ込める
- 複数のコンポーネントで共有する状態が必要な場合は、Pinia または Composition API を活用したストアパターンを検討する

## データ取得
- APIとの通信には `fetch` または `axios` を使用する
- 通信ロジックはコンポーネントから分離し、`src/services/` または `src/api/` に集約することを検討する

## Naming Conventions
- **コンポーネント名**: `PascalCase` (例: `MyComponent.vue`)
- **プロパティ名**: `camelCase` (例: `<MyComponent :user-id="123" />`)
- **イベント名**: `kebab-case` (例: `@click-event`)

## 型定義
- `props` と `emits` には必ず型定義を付与する
```typescript
const props = defineProps<{
  userId: number;
  userName: string;
}>();

const emit = defineEmits<{
  (e: 'update', id: number): void;
}>();
```

---
_このドキュメントはパターンと原則に焦点を当てています。ライブラリの詳細な使い方は公式ドキュメントを参照してください。_
