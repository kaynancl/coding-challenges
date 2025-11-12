# Balanced Brackets

This project focuses on determining whether a sequence of brackets is **balanced**.  
A bracket is considered to be any of the following characters:

- `(`
- `)`
- `{`
- `}`
- `[`
- `]`

## Definition of Balance

Two brackets form a **matched pair** when:

- An opening bracket `(`, `[`, or `{`
- Occurs to the **left** of a closing bracket `)`, `]`, or `}`
- And both are of the **same type**

Valid matching pairs include:

- `()`
- `[]`
- `{}`

A matching pair is **not** balanced if the brackets it encloses are not also balanced.

### Example

`{[(])}` is **not balanced** because:
- Inside `{}`, the sequence `[(])` is not balanced
- Inside `[]`, the enclosed bracket is `(` (unmatched)
- Inside `()`, the enclosed bracket is `]` (unmatched)

### Balanced Sequence Requirements

A sequence of brackets is **balanced** if:

1. It contains **no unmatched brackets**
2. Every pair of brackets encloses a **balanced** subset

---

## Problem Description

Given multiple strings of brackets, determine whether each sequence is balanced.

If the string is balanced, return **`true`**.  
Otherwise, return **`false`**.

---

## Function Description

### `isBalanced(string s)`

**Parameters:**
- `string s`: a sequence of brackets

**Returns:**
- `boolean`: either `true` or `false`

---

## Input Format

- String contains a bracket sequence `s`.

**Constraints:**
- `1 ≤ |s| ≤ 10^5`
- All characters in `s` ∈ `{ {, }, (, ), [, ] }`

---

## Output Format

For each input string, output `true` or `false`.

---

## Sample Input

- `{[()]}`
- `{[(])}`
- `{{[[(())]]}}`

## Sample Output
- `true`
- `false`
- `true`