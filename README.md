# Muted - Minecraft Player Moderation Plugin

A simple yet powerful Minecraft plugin that provides essential moderation tools for managing player communication on your server.

## Features

- Mute/unmute players
- View list of muted players
- Manage banned words
- Automatic message filtering for banned words

## Commands

### Player Muting

| Command | Description |
|---------|------------|
| `/mute <player>` | Mutes the specified player, preventing them from sending chat messages |
| `/demute <player>` | Unmutes the specified player, allowing them to send chat messages again |
| `/listmute` | Displays a list of all currently muted players |

### Word Filtering

| Command | Description |
|---------|------------|
| `/banwords add <word>` | Adds a word to the banned words list. Messages containing this word will be blocked |
| `/banwords remove <word>` | Removes a word from the banned words list |
| `/banwords list` | Displays all currently banned words |

## Installation

1. Download the plugin "Muted-1.0-SNAPSHOT.jar"
2. Place it in your server's `plugins` folder
3. Restart your server or use `/reload`

## Permissions

The plugin uses default Minecraft permission system. Make sure to set up appropriate permissions for your staff members to use these moderation commands.

## Support

If you encounter any issues or have suggestions, please open an issue on our GitHub repository.