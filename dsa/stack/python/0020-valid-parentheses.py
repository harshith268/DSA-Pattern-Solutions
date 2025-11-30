# LeetCode 20: Valid Parentheses
# Pattern: Stack
# Approaches:
# 1) Brute Force


def is_valid_brute(s: str) -> bool:
    prev = None
    while s != prev:
        prev = s
        s = s.replace("()", "").replace("{}", "").replace("[]", "")
    return s == ""

# 2) Optimal (Stack)

def is_valid_optimal(s: str) -> bool:
    stack = []
    pairs = {')': '(', '}': '{', ']': '['}

    for ch in s:
        if ch in "({[":
            stack.append(ch)
        else:
            if not stack or stack.pop() != pairs[ch]:
                return False
    return not stack


if __name__ == "__main__":
    print(is_valid_optimal("({[]})"))  # True

