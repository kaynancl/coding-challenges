# Noble Knots

## Introduction
You've been hired to develop **Noble Knots**, the hottest new dating app for nobility! After centuries of royal intermarriage, things have gotten… complicated.
To avoid any *oops-we're-twins* situations, your mission is to build a system that checks how closely two people are related.

Noble Knots is inspired by Iceland's **Íslendinga-App**, which tracks all known connections between Icelanders going back to the settlement of Iceland.
Your algorithm will determine the **degree of separation** between two individuals in a royal family tree.

*Will your app help crown a perfect match?*

---

## Instructions
Your task is to determine the **degree of separation** between two individuals in a family tree — similar to the pop-culture idea that every Hollywood actor is within six degrees of Kevin Bacon.

You will be given an input containing all parent names and their children.

**Rules:**
- Each name is unique.
- A child can have one or two parents.
- The degree of separation is defined as the **shortest path** between two people.
- If two individuals are not connected, return the value used to indicate **“no known relationship”** (see the test cases for the exact implementation).

---

## Example

Given the following family tree:
graph TD
    
    Helena["Helena"]
    Erdos["Erdős"]
    Shusaku["Shusaku"]
    Isla["Isla"]
    Tariq["Tariq"]
    Uma["Uma"]
    Kevin["Kevin"]
    Morphy["Morphy"]

    Helena --> Isla
    Helena --> Tariq

    Erdos --> Shusaku

    Isla --> Uma
    Tariq --> Morphy

    Shusaku --> Kevin




### Sample relationships
- **Tariq → Isla → Uma** → degree of separation = **2**
- **Uma → Isla** → degree of separation = **1**
- **Isla ↛ Kevin** → **no known relationship**

---

## Note
- Isla and Tariq are siblings → separation **1**.
- This implementation also reports a separation of **2** between a person and their father's brother.

---