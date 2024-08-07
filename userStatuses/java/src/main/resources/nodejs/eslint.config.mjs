import globals from "globals";
import path from "node:path";
import { fileURLToPath } from "node:url";
import js from "@eslint/js";
import { FlatCompat } from "@eslint/eslintrc";
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);
const compat = new FlatCompat({
	baseDirectory: __dirname,
	recommendedConfig: js.configs.recommended,
	allConfig: js.configs.all
});
export default [{
	languageOptions: {
		globals: {
			...globals.browser,
			...globals.node,
		},
	},
	rules: {
		indent: [2, "tab"],
		"no-tabs": 0,
		"require-jsdoc": 0,
	},
}];