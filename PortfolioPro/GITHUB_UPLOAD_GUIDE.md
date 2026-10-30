# Upload PortfolioPro to GitHub (Windows CMD)

1. Extract the project ZIP. Open Command Prompt in the extracted `PortfolioPro` folder.
2. Create an **empty** repository on GitHub. Do not initialize it with a README, license, or `.gitignore` because this project already contains those files.
3. Replace `YOUR_USERNAME` and `YOUR_REPOSITORY` below with your GitHub username and repository name.
4. Run these commands one at a time:

```cmd
git --version
git init
git add .
git status
git commit -m "Initial commit: PortfolioPro full-stack application"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
git push -u origin main
```

If Git asks you to identify yourself, configure the name and email associated with your commits:

```cmd
git config --global user.name "Your Name"
git config --global user.email "your-email@example.com"
```

Then repeat the commit command. GitHub authentication may open a browser sign-in flow. Do not put a password or access token directly into the remote URL or project files.

## Before pushing

- Review `git status` and confirm that no `.env`, passwords, API keys, database dumps, or private files are staged.
- Confirm that `node_modules`, `target`, and `dist` are not included.
- If a secret was ever committed, removing it in a later commit is not enough: rotate/revoke it and clean the Git history before making the repository public.
