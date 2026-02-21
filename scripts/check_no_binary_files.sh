#!/usr/bin/env bash
set -euo pipefail

# Fails if staged files include binary content.
if git diff --cached --numstat | awk '$1=="-" || $2=="-" {exit 1}'; then
  echo "No staged binary files detected."
else
  echo "Binary files detected in staged changes. Please remove them before creating a PR."
  exit 1
fi
