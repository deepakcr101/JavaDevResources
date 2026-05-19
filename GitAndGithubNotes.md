

## **PHASE 1 – Git Fundamentals Refresher**

### **Step 1 – The Mental Model**
At its core, Git isn’t just a bunch of commands — it’s a versioned filesystem with three main areas:

1. **Working Directory**  
   - Your local files on disk.  
   - You edit here.

2. **Staging Area / Index**  
   - A snapshot of changes you *intend* to commit.
   - Like a shopping cart of changes — you can choose what to stage.

3. **Local Repository (.git folder)**  
   - The full history of commits.
   - What you push to a remote like GitLab.

4. **Remote Repository**  
   - Lives on GitLab® in Ciena’s environment.
   - You `push` to it, `pull` from it.

**Diagram:**  
```
[Working Dir] -- git add --> [Staging Area] -- git commit --> [Local Repo] -- git push --> [Remote Repo]
```



### **Step 2 – Must-Know Core Commands**

| Command | Description | Example |
|---------|-------------|---------|
| `git init` | Initialize git in a folder | `git init myproject` |
| `git status` | Show what's changed | `git status` |
| `git add` | Stage changes | `git add file.txt` or `git add .` |
| `git commit -m "msg"` | Save staged changes to repo | `git commit -m "Add login API"` |
| `git log` | Commit history | `git log --oneline --graph` |
| `git diff` | Show unstaged changes | `git diff` |
| `git restore` | Discard changes | `git restore file.txt` |
| `git reset` | Unstage / reset head | `git reset file.txt` |
| `git branch` | List branches | `git branch -a` |
| `git checkout` / `git switch` | Move between branches | `git switch dev` |
| `git merge` | Merge another branch into active branch | `git merge feature/login` |

---

### **Step 3 – Hands-On Practice (Local Only)**  
Do this in a test folder (so you can freely break things).

```bash
# 1. Create and enter a test project
mkdir git-playground && cd git-playground
git init

# 2. Create a file and commit it
echo "Hello Git" > readme.md
git add readme.md
git commit -m "Initial commit"

# 3. Modify and commit changes
echo "My name is John" >> readme.md
git status
git add readme.md
git commit -m "Add author name"

# 4. Create a new branch and switch
git switch -c feature/newcontent
echo "This is new content" >> readme.md
git commit -am "Update readme with new content"

# 5. Merge back into main
git switch main
git merge feature/newcontent

# 6. See history
git log --oneline --graph --decorate --all
```

---

### **Step 4 – Understanding Branches**
- A branch is just a movable pointer to a commit.
- `HEAD` points to your current branch.
- In Git, creating branches is cheap (instant, no duplication).

Example:
```bash
git switch -c new-feature
# HEAD -> new-feature, which points to same commit as main initially
```

---

### **Step 5 – Basics of Undoing**
**Scenario: You made a mistake**
- Undo changes not staged:
  ```bash
  git restore file.txt
  ```
- Unstage a file:
  ```bash
  git reset file.txt
  ```
- Amend last commit:
  ```bash
  git commit --amend -m "Better commit message"
  ```

---


## **PHASE 2 – Team Collaboration & Best Practices**

---

### **Concept 1 – Branching Strategy in Teams**

In a corporate GitLab setup (like at Ciena), you rarely commit directly to `master` or `main`.  
Protected branches enforce rules to avoid overwriting production-ready code.  

**Typical branch naming convention:**
- `feature/<something>` → new features  
- `bugfix/<something>` → bug fixes  
- `hotfix/<something>` → urgent fixes directly into production  
- `release/<version>` → prep for a release

**Example:**
```
feature/login-api
bugfix/email-validation
hotfix/security-patch
release/v1.2.0
```

**Golden rule:**  
✔ Keep your branch small and focused — one feature or fix per branch.  
✔ Regularly pull/rebase from `main`/`master` to keep up-to-date.

---

**Drill #1 — Create a branch with proper naming**
```bash
git switch -c feature/user-profile
```
✅ Create a branch from `master` called `feature/user-profile`, then run:
```bash
git branch
```
and paste output here to confirm current branch.

---

### **Concept 2 – Commit Message Standards**

Good commit messages are essential for:
- Code reviews
- Debugging history
- Change logs

**Common corporate standard:**
```
<type>: <short summary>

[optional longer description / context]
```

Where `<type>` could be:
- feat → new feature
- fix → bug fix
- docs → documentation only
- refactor → code refactor without new features
- test → adding/modifying tests

**Example:**
```
feat: add user profile API
fix: correct null pointer in auth module
```

---

**Drill #2 — Make a good commit**
1. In your `feature/user-profile` branch:
```bash
echo "User profile feature WIP" >> profile.txt
git add profile.txt
git commit -m "feat: add initial user profile module"
```
2. Run:
```bash
git log --oneline -1
```
Paste result here — we’ll check if your commit message fits the convention.

---

### **Concept 3 – Merge Request (MR) Etiquette in GitLab**

**Best Practices Before Creating MR:**
1. Sync with latest `master` / `main`
    - `git fetch origin`
    - `git pull --rebase origin master`
2. Review your own diff before submission:  
    - `git diff origin/master`
3. Keep changes focused — avoid mixing unrelated edits.
4. Assign reviewers and link Jira/issue IDs in MR description.
5. Squash commits if there are too many “noise” commits like `fix typo`.

---

**Drill #3 — Simulate update from main before MR**
1. Switch back to `master`:
```bash
git switch master
```
2. Simulate that `master` has a new commit:
```bash
echo "Master branch update" >> master-update.txt
git add master-update.txt
git commit -m "chore: update from master branch"
```
3. Switch to your `feature/user-profile` and rebase from master:
```bash
git switch feature/user-profile
git pull --rebase . master
```
Paste output — this simulates pulling latest code before MR submission.  

---

### **Concept 4 – Pull vs. Pull with Rebase**
- `git pull` = fetch + merge → creates a merge commit if changes exist.
- `git pull --rebase` = fetch + reapply your commits on top of latest → keeps history linear (preferred in many corporate workflows).

**When in doubt**:  
- Teams often standardize to `git pull --rebase` for cleaner history.  
- Merge commits are fine for large merges but avoid for day-to-day sync.

---

### **Concept 5 – .gitignore and Clean Working Trees**
- Use `.gitignore` to avoid committing compiled binaries, temp files, IDE configs.
- Keep working tree clean:
    - `git status` should ideally be "nothing to commit, working tree clean".
    - Commit frequently in small, logical chunks.

**Example `.gitignore`**
```
# OS stuff
.DS_Store
Thumbs.db

# Python
__pycache__/
*.pyc

# Node
node_modules/

# IDE
.vscode/
.idea/
```
---

We use ``git switch`` instead of ``git checkout and git branch`` as this is the new standard.

---

## **PHASE 3 – GitLab-Specific Workflows**

In GitLab (internal corporate setup), repos are usually **private** and have access permissions set by team administrators.  
The workflow depends on whether you have **direct write access** or not.

---

### **Concept 1 – Clone vs Fork in Corporate Environment**

**Clone**  
- Use when you have **direct access** (write permissions) to the repo.
- Typical for internal team-owned repos.
- You work directly in feature branches inside that repo.
- Example:
  ```bash
  git clone git@gitlab.ciena.com:team/project-repo.git
  ```
- Remote name is `origin` → points to GitLab repo.

---

**Fork**  
- Use when you **don’t have write permissions** to the upstream repo, or when contributing to shared repos across teams/departments.
- Fork creates your own copy of the repo under your namespace in GitLab.
- You clone your fork, work on feature branches, then open an MR to upstream repo.
- Example:
  ```bash
  git clone git@gitlab.ciena.com:username/project-repo.git
  git remote add upstream git@gitlab.ciena.com:team/project-repo.git
  ```
- `origin` = your fork,  
  `upstream` = original repo.

---

**Ciena Context:**  
- Most likely, you’ll be **cloning directly** because you’re in the team’s GitLab group.
- Fork workflow might be used for cross-team contributions.

---

### **Concept 2 – SSH vs HTTPS for Cloning**
- SSH is preferred in corporate environments:
  - No password prompts every time.
  - More secure.
  - Works with MFA corporate environment.
- Set up SSH key:
  ```bash
  ssh-keygen -t rsa -b 4096 -C "your.email@ciena.com"
  # Press enter for default location (~/.ssh/id_rsa)
  cat ~/.ssh/id_rsa.pub
  ```
- Add the public key to GitLab profile → **User Settings → SSH Keys**

---

### **Concept 3 – Keeping Local Repo Updated**
**If Cloned Directly (origin only):**
```bash
git pull --rebase origin master
```

**If Forked (origin + upstream):**
```bash
git fetch upstream
git rebase upstream/master
git push origin feature/user-profile
```

---

### **Concept 4 – Merge Requests in GitLab**
**Best Practice MR Steps**
1. Push your feature branch:
   ```bash
   git push origin feature/user-profile
   ```
2. Create MR in GitLab:
   - Source branch = your feature branch
   - Target branch = master (or main)
3. Add reviewers
4. Link JIRA ticket
5. Make description clear:
   - What problem it solves
   - Testing done
   - Any risks

---

### **Concept 5 – GitLab CI Basics**
- GitLab runs `.gitlab-ci.yml` pipeline on MR.
- Pipelines may fail if:
  - Unit tests fail,
  - Lint checks fail,
  - Security scans fail.
- **Tip:** Run tests locally before pushing.

---

## **Phase 3 – Interactive Drill**

We’ll simulate both workflows (clone direct & fork):

---

### **Drill Part 1 – Direct Clone Workflow**
1. Create a “remote” simulation locally:
```bash
mkdir remote-repo && cd remote-repo
git init --bare
cd ..
```
2. Clone directly from “remote”:
```bash
git clone ./remote-repo project-clone
cd project-clone
```
3. Add a file in `master` branch and commit:
```bash
echo "Direct clone example" > direct.txt
git add direct.txt
git commit -m "feat: direct clone workflow"
git push origin master
```

---

### **Drill Part 2 – Fork Workflow Simulation**
1. Simulate upstream remote:
```bash
mkdir upstream-repo && cd upstream-repo
git init --bare
cd ..
```
2. Simulate fork:
```bash
git clone ./upstream-repo fork-repo
cd fork-repo
```
3. Add upstream remote reference:
```bash
git remote add upstream ../upstream-repo
git remote -v
```
4. Create branch, commit, rebase:
```bash
git switch -c feature/fork-test
echo "Fork workflow test" > fork.txt
git add fork.txt
git commit -m "feat: fork workflow example"
git fetch upstream
git rebase upstream/master
```
5. Push fork branch:
```bash
git push origin feature/fork-test
```

---
In Git, a branch is created only once it has a commit.
An empty bare repo has no commits, so it has no HEAD branch — nothing exists to fetch or track.

---
---

## **Understanding the Pipeline/Flow of Changes**

### **Case 1 – Direct Clone (you have write access)**
**Ownership:** Repo is owned by your team.  
You have **permission to push directly**.

📊 **Flow:**
```
[Your Local Repo] ⇄ origin (Team Repo on GitLab)
```

**Day-to-day:**
1. Clone team repo → local copy (`origin` points to it).
2. Create a feature branch locally.
3. Make commits.
4. **Before MR:**  
   - `git fetch origin`  
   - `git pull --rebase origin master` (or main) → update your branch to latest upstream changes without extra merge commits.
5. Push your branch: `git push origin feature/xyz`
6. Create MR in **same repo** (source branch = your feature branch, target = master).

✅ **Advantages:** No need for `upstream`, only `origin` is needed.

---

### **Case 2 – Fork Workflow (you DO NOT have write access)**
**Ownership:** Repo is owned by another team or is a shared/multi-team project.  
You **cannot push directly** to the upstream repo.

📊 **Flow:**
```
[Your Local Repo] ⇄ origin (Your Fork on GitLab) ⇄ upstream (Original Repo on GitLab)
```
- `origin` = **your fork** (you own it, full write access)
- `upstream` = **original repo** (read-only for you)

---

**Step-by-Step Data Flow in Fork Scenario:**

#### **1. Initial Setup**
- Fork the repo in GitLab → creates a **copy of upstream** under your namespace.
- Clone **your fork** locally:
  ```bash
  git clone git@gitlab.com:yourname/project.git
  ```
  → This sets `origin` = your fork.
- Add upstream remote (read-only original repo):
  ```bash
  git remote add upstream git@gitlab.com:team/project.git
  ```

---

#### **2. Working on a Feature**
- Create a branch in your local repo:
  ```bash
  git switch -c feature/xyz
  ```
- Make changes and commit locally.
- **Push** branch to your fork:
  ```bash
  git push origin feature/xyz
  ```

---

#### **3. Staying Up-to-Date**
- Meanwhile, upstream master might get updates (from other devs).
- You need to **bring those changes into your local branch** before making an MR to upstream:
  ```bash
  git fetch upstream
  ```
  *(This downloads latest commits of upstream without overwriting local work)*

---

#### **4. Rebase Your Feature Branch**
- While on `feature/xyz` branch:
  ```bash
  git rebase upstream/master
  ```
  *(This takes your commits and replays them on top of the latest `upstream/master` commits)*
- If there are conflicts, resolve them, continue rebase:
  ```bash
  git rebase --continue
  ```

---

#### **5. Push Rebased Branch to Your Fork**
- Your local branch history has changed after rebase → **force push** to your fork:
  ```bash
  git push origin feature/xyz --force
  ```

---

#### **6. Create MR in GitLab**
- Go to **your forked repo page** in GitLab.
- Create MR:
  - Source: your fork’s `feature/xyz` branch.
  - Target: upstream repo’s `master` branch.

---

### **Diagram: Fork Case Pipeline**
```
(upstream/master) — main project owned by Team A
       ↑ (fetch only, read-only)
       │
[Your Local Repo: feature/xyz branch] ↔ (push/pull) ↔ origin (your fork, write access)
```
- **Fetching from upstream:** pulls latest “truth” from the main project.
- **Rebasing:** integrates your changes on top of that truth.
- **Pushing to origin:** updates your personal fork with the rebased version.
- **Merge Request:** from your fork → upstream project.

---

### **In Short – Your Summary Restated**
✅ **Direct clone case (team-owned repo)**: update from `origin/master` → rebase → push → MR in same repo.  
✅ **Fork case (no write access)**:  
- work on clone of your fork (origin)
- keep fork in sync with upstream via `git fetch upstream` → `git rebase upstream/master`
- push branch to origin (force push after rebase)
- MR from fork → upstream

---
# **📌 Phase 3 Remaining Topics**

---

## **1. GitLab UI Basics**  
Although most developers think in terms of Git commands, **GitLab’s web UI** is where a lot of project collaboration happens — especially for code reviews, Merge Requests, pipelines, and documentation.  

Here’s what you should know:

### **Repo Page Layout**
When you open a repository in GitLab, you’ll typically see:
- **Repository → Files**: Browse the code.  
- **Repository → Commits**: See commit history.
- **Repository → Branches**: View all branches, create new ones (if permitted).
- **Repository → Tags**: View releases or version tags.

---

### **Merge Request Section**
- List of MRs:
  - **Open** MRs are active code changes waiting for review.
  - Closed MRs (merged or rejected).
- **MR Details Page**:
  - **Description** (linked JIRA/issue, what has changed, testing info).
  - **Changes Tab**: Shows diff between source & target branches.
  - **Pipelines Tab**: Shows CI/CD job status for this MR.
  - **Commits Tab**: Shows commits in this MR.

---

### **Issues Section**  
- GitLab can track issues (similar to Jira, but many companies like Ciena use Jira instead).
- Can be linked to commits and MRs via issue IDs in commit messages (`ABC-123`).

---

### **CI/CD Pipeline Page**  
- **Pipelines**: A list of all GitLab CI/CD pipeline runs with success/fail status.
- **Jobs**: Individual steps in a pipeline (build, test, deploy).
- **Environments**: Deployed environments (e.g., staging, production).

---

### **Wiki & Snippets**
- Some teams use GitLab’s Wiki for project-related documentation.  
- Snippets = small reusable code/config fragments.

---

**💡 Tip at Ciena:**  
When you push your branch, always visit your **Merge Request in the UI** and:
1. Skim through the diff for obvious mistakes.
2. Ensure the MR title & description match expectations.
3. Check that reviewers are assigned.
4. Make sure pipelines pass before requesting review.

---

## **2. GitLab CI/CD Basics & `.gitlab-ci.yml`**

In GitLab, CI/CD pipelines are configured **per repository** using a file at the project’s root named:
```
.gitlab-ci.yml
```

---

### **Purpose**
- Defines the automated steps that run when:
  - You **push code**
  - You **create/update an MR**
- Steps include:
  - Building code
  - Running tests
  - Linting
  - Security scans
  - Deployments

---

### **Basic `.gitlab-ci.yml` Structure**

Example:
```yaml
stages:
  - build
  - test
  - deploy

build-job:
  stage: build
  script:
    - echo "Compiling the project..."
    - make

unit-tests:
  stage: test
  script:
    - echo "Running tests..."
    - pytest

deploy-staging:
  stage: deploy
  script:
    - echo "Deploying to staging..."
  only:
    - main
```

---

### **Key Concepts**
- **stages**: Order in which jobs run.
- **jobs**: Each top-level key (e.g., `build-job`) is a job with:
  - **stage**: Which stage it belongs to.
  - **script**: Series of shell commands.
  - **only/except**: Which branches/tags trigger this job.
- **runners**: Servers/agents that execute CI/CD jobs.
  - At Ciena, runners may be pre-configured (shared CI runners) or specific to a team.

---

**💡 Developer Tips for `.gitlab-ci.yml`**
- Always commit valid syntax — a bad `.gitlab-ci.yml` file can block *all* pipelines.
- Use **pipeline simulation** in GitLab UI:  
  Repo → CI/CD → Editor → Lint to validate YAML before pushing.
- If your MR fails in CI, GitLab pipeline logs will tell you exactly which job failed — fix locally before retry.

---

### **How CI/CD Fits in MR Workflow**
1. You push → GitLab runs the `.gitlab-ci.yml` pipeline → MR shows build/test results.
2. If any job fails, MR shows a red ❌ in "Pipelines".
3. Most teams block merging until pipelines are all ✅ green.

At Ciena, this means:
- You **must keep your branch in sync** with `master` to pass CI (Phase 3’s rebase advice).
- Make sure you can run at least lint/tests locally before pushing.

---

# **📌 Phase 4 – Advanced Git Skills**

---

## **Skill 1 – `git stash` (and `git stash pop`)**

### **Concept**
**Problem scenario:**  
You’re halfway through coding a feature when your team says,  
_"We need you to quickly checkout another branch and fix a production bug."_  
But you can't commit yet because your code is incomplete.

**Solution → `git stash`:**  
Temporarily saves your *uncommitted* changes so your working directory is clean,  
letting you switch branches or pull updates without losing work.

---

### **Key Commands**
- Stash changes:
  ```bash
  git stash
  ```
- View stashes:
  ```bash
  git stash list
  ```
- Apply the latest stash:
  ```bash
  git stash pop
  ```
- Apply without removing from stash history:
  ```bash
  git stash apply
  ```
- Drop a stash:
  ```bash
  git stash drop stash@{0}
  ```

---

**💡 Ciena Context:**  
During urgent bugfixes, stashing is common to quickly switch away from incomplete features without polluting the commit history.

---

### **Drill 1 – Stashing**
1. On **any branch** in your `git-playground`:
```bash
echo "Temporary WIP Change" >> stash-demo.txt
git status    # should see modified file
git stash
git status    # should now be clean
git stash list
```
2. Now "restore" your WIP:
```bash
git stash pop
```
By default, git stash only stashes tracked changes.
Our file stash-demo.txt was untracked because you haven’t run git add on it yet.
---

## **How to Stash Untracked Files**

You have two options:

1. **Track it first** (recommended if you actually want this to be part of your repo):
   ```bash
   git add stash-demo.txt
   git stash
   ```

2. **Stash including untracked files** (works for temporary files you don’t want in commits):
   ```bash
   git stash -u
   ```
   or the longer form:
   ```bash
   git stash push -u
   ```
   `-u` = include untracked files  
   `-a` = include ignored files (rare in normal dev)

---

### **Let’s Try Again – Stash Drill**

**Step 1** – Create & stash untracked file:
```bash
echo "Temporary WIP Change" >> stash-demo.txt
git status            # see untracked file
git stash -u          # stash including untracked files
git status            # should now be clean
git stash list        # see stash entry
```

**Step 2** – Pop it back:
```bash
git stash pop
```

---

### **Ciena Context Tip**
When you're mid-feature and must switch branches urgently:
- If the files are **already tracked** → `git stash`
- If files are **new/untracked** → `git stash -u`

---
## **Skill 2 – Interactive Rebase (`git rebase -i`)**

### **Concept**
Interactive rebase allows you to:
- **Reorder commits**
- **Squash commits together** (combine multiple commits into one)
- **Edit commit messages**
- **Drop commits**

**Why Use It:**
1. You’ve made many small commits while developing (e.g., small fixes).
2. Before MR, you want to **present a concise history** — usually fewer, logically grouped commits.
3. CI/CD pipelines sometimes trigger per commit — clean history avoids unnecessary runs.

---

### **Key Commands**
- Start an interactive rebase for the last N commits:
  ```bash
  git rebase -i HEAD~N
  ```
  Example: `git rebase -i HEAD~3` → interactively rewrite last 3 commits.
- Actions available in rebase editor:
  ```
  pick   commit_hash message   # leave unchanged
  reword commit_hash message   # change commit message
  squash commit_hash message   # combine into previous commit
  drop   commit_hash message   # remove commit
  ```
- Save & close → Git rewinds commits, applies changes.

---

### **Example Workflow**
You might have:
```
abc123 feat: add user profile API
def456 fix: typo in user profile
ghi789 fix: formatting
```
Before MR, you might squash `def456` & `ghi789` into `abc123` so history becomes:
```
xyz000 feat: add user profile API
```

---

## **Interactive Drill 2 – Clean History**
We’ll simulate this in your **git-playground** repo:

1. Create a few commits:
```bash
echo "Commit 1" >> rebase-demo.txt
git add rebase-demo.txt
git commit -m "feat: commit 1"

echo "Commit 2" >> rebase-demo.txt
git add rebase-demo.txt
git commit -m "fix: commit 2 minor change"

echo "Commit 3" >> rebase-demo.txt
git add rebase-demo.txt
git commit -m "fix: commit 3 minor change"
```

2. View history:
```bash
git log --oneline
```

3. Run interactive rebase for last 3 commits:
```bash
git rebase -i HEAD~3
```
In the editor:
- Keep the first commit `pick`
- Change `fix: commit 2 minor change` → `squash`
- Change `fix: commit 3 minor change` → `squash`

4. When prompted for new commit message, write:
```
feat: commit 1 with minor fixes included
```

5. Save, finish rebase.

6. Check history:
```bash
git log --oneline
```
You should now see **only 1 commit** instead of 3.

---

**💡 Ciena Context:**  
Before submitting a Merge Request, squashing small/noisy commits makes your MR easier to review and keeps the repo history clean.

---

## **Skill 3 – Cherry-picking (`git cherry-pick`)**

### **Concept**
**Problem scenario:**  
You made a useful commit on one branch, but you also need it in another branch **without merging** all changes from that branch.

**Solution → `git cherry-pick`:**  
It applies a specific commit from one branch directly into another.

---

**When to Use:**
- Hotfix applied in `master` also needed in `release/1.0` branch.
- You want part of someone’s feature but not full branch merge.

---

### **Key Command**
```bash
git cherry-pick <commit-hash>
```
- Finds commit by hash (`git log --oneline`).
- Applies that single commit to current branch.

---

### **Interactive Drill – Cherry-pick**
1. In `git-playground`:
```bash
git switch master
echo "Cherry-pick commit" >> cherry.txt
git add cherry.txt
git commit -m "fix: important cherry-pick change"
```

2. View commit hash:
```bash
git log --oneline
```

3. Switch to another branch (e.g. `feature/newcontent`) and cherry-pick it:
```bash
git switch feature/newcontent
git cherry-pick <commit-hash>
```

4. The commit should now be in `feature/newcontent`.

---

💡 **Ciena Context:**  
Cherry-picking is common for propagating small fixes to multiple active release branches without pulling unrelated changes.

---

## **Skill 4 – Bisect (`git bisect`)**

### **Concept**
**Problem scenario:**  
A bug exists, but you don’t know **which commit introduced it**.  

**Solution → `git bisect`:**  
Binary-search through commit history by marking commits as **good** or **bad**, letting Git narrow down to the offending commit.

---

**Workflow**:
```bash
git bisect start
git bisect bad              # marks current commit as bad
git bisect good <hash>      # marks an older commit as good
# Git automatically checks out a midpoint
# You test; mark good/bad accordingly
```
When done:
```bash
git bisect reset
```

---

**Interactive Drill – Bisect**
We’ll simulate:
1. Make a file evolve over 5 commits.
2. Pretend commit 3 is "buggy".
3. Start `git bisect`, test commits, mark `good` and `bad`, Git finds commit 3.

**Note:** This is more conceptual; actual testing is manual in CLI.

---

💡 **Ciena Context:**  
Used mostly when debugging regressions in large codebases — fastest way to discover which change caused a failure.

---

## **Skill 5 – Tagging Releases (`git tag`)**

### **Concept**
**Problem scenario:**  
You want to mark certain commits as official releases for deployment & tracking.

**Solution → `git tag`:**
- Tags are pointers to specific commits, often named using semantic versioning.

---

### **Types of Tags**
- **Lightweight**: Just a name pointing to commit.
  ```bash
  git tag v1.0
  ```
- **Annotated**: Includes metadata (recommended for releases).
  ```bash
  git tag -a v1.0 -m "Release version 1.0"
  ```

---

### **Working with Tags**
- List tags:
```bash
git tag
```
- Push a tag:
```bash
git push origin v1.0
```
- Push all tags:
```bash
git push origin --tags
```
- Checkout a tag:
```bash
git checkout v1.0
```

---

### **Interactive Drill – Tag**
1. Create a commit in master:
```bash
git switch master
echo "Release content" >> release.txt
git add release.txt
git commit -m "chore: prepare for release"
```

2. Tag it:
```bash
git tag -a v1.0 -m "Release version 1.0"
git tag
```

3. Push to origin:
```bash
git push origin v1.0
```

---

💡 **Ciena Context:**  
Tags are essential in GitLab for:
- CI/CD pipelines: Deploy only on tags (release branches).
- Rollback points: Easy to revert to a tagged stable release.

---

✅ **Phase 4 Recap:**
1. `git stash` – Shelve changes temporarily.
2. Interactive rebase – Clean up commit history before MR.
3. `git cherry-pick` – Apply specific commit across branches.
4. `git bisect` – Identify which commit introduced a bug.
5. `git tag` – Mark commits for releases & deployments.

---
## **📌 Phase 5 – Ciena-Specific Adaptation Checklist**

---

### **1️⃣ Understand Your Team’s Branching Strategy**
Every team has a slightly different branching model depending on product release cycles and CI/CD setup.

Common strategies you might encounter:
- **Git Flow**:
  - `master` (stable production code)
  - `develop` (integration branch for upcoming features)
  - `feature/xyz` → merged into `develop`
  - `release/x.y.z`
  - `hotfix/x.y.z`
- **Trunk-Based Development**:
  - `main` (or `master`) is always deployable
  - Short-lived feature branches → merged quickly
- **Custom Variants** at Ciena:
  - Some teams may have “long-lived” release branches.

✅ **Ask your lead:**
- What is our default branch called (`main` / `master` / `develop`)?
- Are releases tagged or branched?
- How long do feature branches live before merge?

---

### **2️⃣ Commit Squash Policy**
Some teams prefer:
- **Squash merge**: All commits in a branch become a single commit in target branch → keeps history clean.
- **No squash**: Preserve individual commit history for traceability.

✅ **Ask your lead:**
- Should I squash commits before MR or will GitLab squash on merge?
- Are multiple small commits acceptable in MR?

---

### **3️⃣ Code Review Expectations**
In GitLab:
- MR reviewers expect:
  - Clear description: What changed & why.
  - Linked JIRA ticket.
  - Tests updated (unit/integration).
  - Pipeline passing.
- Review comments:
  - May require changes before MR approval.
  - Address feedback promptly.

✅ **Ask your lead:**
- Who should be assigned as reviewer for each change?
- Do we use “Approve” before merge or can leads merge directly?

---

### **4️⃣ Pre-commit Hooks & CI/CD Rules**
Many corporate repos (including Ciena) have **pre-commit hooks** or **CI/CD jobs** that must pass:
- Linting / formatting checks.
- Unit tests.
- Security scans.
- Build must be green before merge.

✅ **Ask your lead:**
- Are there custom hooks in `.git/hooks` or `pre-commit` scripts?
- Do I need to run tests locally before pushing?
- Which CI/CD jobs are “blocking” for merge?

---

### **5️⃣ Remote Setup & Access**
- Use SSH keys for GitLab access (set up once).
- For **internal repos**:
  - Direct clone (origin points to team repo).
- For **cross-team repos**:
  - Fork → origin = your fork, upstream = original.

✅ **Ask your lead:**
- Do we work in direct clone or fork mode for this repo?
- Is `main` protected via GitLab permissions?

---

### **6️⃣ Merge Request SOP in Ciena**
**Before creating MR:**
1. Ensure branch name follows team convention.
2. Commit messages are semantic & meaningful.
3. Sync with latest base branch:
   - Direct clone:  
     ```bash
     git pull --rebase origin master
     ```
   - Fork:  
     ```bash
     git fetch upstream
     git rebase upstream/master
     ```
4. Push feature branch:
   ```bash
   git push origin feature/xyz
   ```
5. Create MR in GitLab:
   - Source branch: feature branch
   - Target branch: master/main
   - Fill MR details clearly
6. Ensure CI pipelines pass ✅
7. Assign reviewers.
8. Respond quickly to review feedback.

---

### **7️⃣ Post-Merge Cleanup**
- Delete merged feature branch locally & remotely:
```bash
git branch -d feature/xyz
git push origin --delete feature/xyz
```
- Pull latest `master` to remain up-to-date:
```bash
git switch master
git pull origin master
```

---

## **🎯 Final Goal**
When you join project work at Ciena, **in the first few days, ask your lead**:
1. **Branching model** (Git Flow, trunk-based, custom).
2. **Default branch name** (`main`, `master`, `develop`).
3. **Squash policy** before merging.
4. **Code review expectations** (depth, speed, style).
5. **CI/CD blocking rules** and required local tests.
6. **Clone vs Fork** policy for repos.
7. **Protected branch rules** (who can merge).

---

## **Quick Visual Cheat-Sheet**

**Clone Workflow (team repo)**  
```
Local Feature Branch → origin/master (sync via pull/rebase) → MR → merge → master
```

**Fork Workflow (cross-team repo)**  
```
Local Feature Branch → origin (your fork) → MR → upstream/master
(upstream sync via fetch/rebase before pushing)
```

---